package com.example.springincontainer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Runtime.getRuntime;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BenchmarkController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/inspect")
    public Map<String, String> inspect() {
        var runtime = getRuntime();
        var map = new HashMap<String, String>();

        // CPUs and Memory
        map.put("availableProcessors", Integer.toString(runtime.availableProcessors()));
        map.put("maxMemory (MB)", Long.toString(runtime.maxMemory() / 1024 / 1024));
        map.put("totalMemory (MB)", Long.toString(runtime.totalMemory() / 1024 / 1024));

        // Garbage Collector
        var gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (var gcBean : gcMxBeans) {
            map.put(gcBean.getName(), gcBean.getObjectName().toString());
        }

        // OperatingSystem MX Bean
        var osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        map.put("osMXBean.getCommittedVirtualMemorySize", bytesToMBString(osBean.getCommittedVirtualMemorySize()));
        map.put("osMXBean.getTotalPhysicalMemorySize", bytesToMBString(osBean.getTotalPhysicalMemorySize()));
        map.put("osMXBean.getFreePhysicalMemorySize", bytesToMBString(osBean.getFreePhysicalMemorySize()));
        map.put("osMXBean.getTotalSwapSpaceSize", bytesToMBString(osBean.getTotalSwapSpaceSize()));
        map.put("osMXBean.getFreeSwapSpaceSize", bytesToMBString(osBean.getFreeSwapSpaceSize()));
        map.put("osMXBean.getSystemCpuLoad", Double.toString(osBean.getSystemCpuLoad()));
        map.put("osMXBean.getProcessCpuLoad", Double.toString(osBean.getProcessCpuLoad()));
        map.put("osMXBean.getSystemLoadAverage", Double.toString(osBean.getSystemLoadAverage()));
        map.put("osMXBean.getProcessCpuTime", Double.toString(osBean.getProcessCpuTime()));
        map.put("osMXBean.getAvailableProcessors", Integer.toString(osBean.getAvailableProcessors()));

        map.put("cpu_shares", System.getProperty("cpushares"));

        return map;
    }

    private String bytesToMBString(long bytes) {
        return Long.toString(bytes / 1024 / 1024) + " MB";
    }

}
