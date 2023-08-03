package com.example.mesh.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MeshEntity {
    
    private final int meshCode;

    @Setter
    private boolean isProcessed;

    public MeshEntity(int meshCode){
        this.meshCode = meshCode;
    }    

}
