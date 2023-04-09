package kodlama.io.rentACar.api.controllers;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.dto.requests.create.CreateModelRequest;
import kodlama.io.rentACar.business.dto.requests.update.UpdateModelRequest;
import kodlama.io.rentACar.business.dto.responses.create.CreateModelResponse;
import kodlama.io.rentACar.business.dto.responses.get.GetAllModelsResponse;
import kodlama.io.rentACar.business.dto.responses.get.GetModelResponse;
import kodlama.io.rentACar.business.dto.responses.update.UpdateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
    private final ModelService service;

    @GetMapping
    public List<GetAllModelsResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetModelResponse getById(@PathVariable int id){
        return service.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //201
    public CreateModelResponse add(@RequestBody CreateModelRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateModelResponse update(@PathVariable int id, @RequestBody UpdateModelRequest brand){
        return service.update(id,brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }



}
