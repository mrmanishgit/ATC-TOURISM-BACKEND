package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.entity.Packages;
import com.aja.serviceImpl.PackageServiceImpl;

@RestController
@RequestMapping("/api/package")
public class PackagesController {
	@Autowired
	PackageServiceImpl packageImpl;
	@PostMapping
	public ResponseEntity<Packages> createPackage(@RequestBody Packages p)
	{
		return ResponseEntity.ok(packageImpl.addPackage(p));
	}
	@GetMapping("/all")
	public List<Packages> fetchAll()
	{
		return packageImpl.viewPackages();
	}
	@GetMapping("/{packageId}")
	public ResponseEntity<Packages> getPackage(@PathVariable Long packageId)
	{
		Packages ps=packageImpl.getPackage(packageId);
		return ResponseEntity.ok(ps);
	}
	@PutMapping("/update/{packageId}")
	public ResponseEntity<Packages> upadte(@PathVariable Long packageId,@RequestBody Packages p)
	{
		return ResponseEntity.ok(packageImpl.updatePackage(packageId, p));
	}
	
}
