package com.drive.modules.supplier.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.supplier.controller.request.SupplierRequest;
import com.drive.modules.supplier.model.Supplier;
import com.drive.modules.supplier.service.SupplierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService service;

    @GetMapping
    public ResponseEntity<List<Supplier>> getSuppliers() {
        return ResponseEntity.ok(service.getSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int id) {
        return ResponseEntity.of(service.getSupplierById(id));
    }

    @PostMapping
    ResponseEntity<Supplier> createSupplier(@RequestBody SupplierRequest supplier) {
        return ResponseEntity.ok(service.createSupplier(supplier));
    }
}
