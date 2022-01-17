# Our containers
declare -a containers=("plainjava" "traditionalcontainer")

# Get the startup time for each container
echo "Image| size| Startup"
for i in "${containers[@]}"
do
    id=$(docker inspect --format="{{.Id}}" $i )
    shortid=${id:7:10}
    echo $id
    echo $shortid
    START=$(docker inspect --format='{{.State.StartedAt}}' $shortid | xargs gdate +%s%3N -d)
    STOP=$(docker inspect --format='{{.State.FinishedAt}}' $shortid | xargs gdate +%s%3N -d)
    SIZE=$(docker image inspect $i --format='{{.Size}}' | awk '{ foo = $1 / 1024 / 1024 ; print foo "MB" }')
    echo "$i| $SIZE| $(($STOP-$START)) ms"
done
