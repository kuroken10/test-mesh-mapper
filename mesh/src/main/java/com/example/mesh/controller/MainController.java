package com.example.mesh.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;

import com.example.mesh.entities.MeshEntity;
import com.example.mesh.services.MeshManager;
import com.example.mesh.services.MeshProcessService;

@Controller
public class MainController {

    private final MeshManager meshManager;

    private final MeshProcessService meshProcessService;

    public MainController(MeshManager meshManager, MeshProcessService meshProcessService) {
        this.meshManager = meshManager;
        this.meshProcessService = meshProcessService;
    }

    public void strat() {

        try {
            var meshList = meshManager.getMeshList();

            List<CompletableFuture<MeshEntity>> futureMeshList = meshList.stream()
                .map(m -> meshProcessService.doMeshProcess(m))
                .collect(Collectors.toList());

            // for (MeshEntity mesh : meshList) {
            //     System.out.println(mesh.getMeshCode());
            // }

            CompletableFuture.allOf(futureMeshList.toArray(new CompletableFuture[futureMeshList.size()])).join();
            System.out.println("finished");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
