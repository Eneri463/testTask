package com.example.testTask.models.compositeKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Data
public class AllModelsId implements Serializable {

    @Column(name = "appliances_id")
    private Long appliancesId;
    @Column(name = "model_id")
    private Long modelId;

    public AllModelsId(Long appliancesId, Long modelId) {
        super();
        this.appliancesId = appliancesId;
        this.modelId = modelId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((appliancesId == null) ? 0 : appliancesId.hashCode());
        result = prime * result
                + ((modelId == null) ? 0 : modelId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AllModelsId other = (AllModelsId) obj;
        return Objects.equals(getAppliancesId(), other.getAppliancesId()) && Objects.equals(getModelId(), other.getModelId());
    }

}
