package com.example.mesh.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.mesh.entities.MeshEntity;

@Service
public class MeshProcessService {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    @Async
    public CompletableFuture<MeshEntity> doMeshProcess(MeshEntity mesh) {

        try {
            Thread.sleep(1000);

            var date = new Date();
            System.out.println(String.format("%s --- %d", df.format(date), mesh.getMeshCode()));

            mesh.setProcessed(true);
            return CompletableFuture.completedFuture(mesh);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
