package com.temp.temp.Workspace.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class WorkspaceController {
    @GetMapping("/new-workspace")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/get-workspace")
    public ResponseEntity<String> register(@RequestParam String id) {
        return ResponseEntity.ok("Success");
    }
    
}
