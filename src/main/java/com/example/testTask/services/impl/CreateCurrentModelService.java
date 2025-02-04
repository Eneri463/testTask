package com.example.testTask.services.impl;

import com.example.testTask.dto.ModelDTO;
import com.example.testTask.dto.ModelRequestDTO;
import com.example.testTask.models.*;
import com.example.testTask.services.*;
import org.springframework.stereotype.Component;

@Component
public class CreateCurrentModelService {
    ApplianceServiceInterface applianceService;
    ColourServiceInterface colourService;
    SizeServiceInterface sizeService;

    public Model createModel(ModelRequestDTO request)
    {
        Appliance appliance = applianceService.getById(request.getApplianceId());

        Colour colour = colourService.getByName(request.getColour());

        if (colour == null)
            colour = colourService.create(new Colour(null, request.getColour()));

        Size size = sizeService.getByNameAndType(request.getSize(), appliance.getType());

        if (size == null)
            size = sizeService.create(new Size(null, request.getSize(), appliance.getType()));

        Model model = new Model(null, colour.getName(), request.getSerialNumber(), colour, size, request.getPrice(), request.isAvailable(), appliance);

        return model;
    }
}
