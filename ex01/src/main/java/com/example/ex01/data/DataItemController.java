package com.example.ex01.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/data")
public class DataItemController {
    
    @Autowired
    ItemRepository itemRepository;

    @Operation(summary = "Create a new shopping item")
    @ApiResponses(value ={
        @ApiResponse(responseCode = "201", description = "Item created", content = @Content)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public DemoItem creaDemoItem(@RequestBody DemoItem item){

        itemRepository.save(item);
        return item;
    }

    @Operation(summary = "Returns a list of shopping items")
    @GetMapping(produces = "application/json")
    List<DemoItem> getAllDemoItems(){
        return itemRepository.findAll();
    }
}
