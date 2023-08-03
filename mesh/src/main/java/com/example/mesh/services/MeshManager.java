package com.example.mesh.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.mesh.entities.MeshEntity;

import lombok.Getter;

@Service
public class MeshManager {

    @Getter
    private List<MeshEntity> meshList = new ArrayList<MeshEntity>();

    public MeshManager() {
        try {
            var is = new ClassPathResource("meshlist.txt").getInputStream();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

                String line;
                while((line = br.readLine()) != null){
                    var meshCode = Integer.valueOf(line);
                    meshList.add(new MeshEntity(meshCode));
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
