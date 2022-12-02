package com.chriwong.dataannotationsdemo.controller;

import com.chriwong.dataannotationsdemo.service.UpdaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MyController {

    private final UpdaterService updaterService;

    public MyController(UpdaterService updaterService) {
        this.updaterService = updaterService;
    }

    /**
     * Attempts to "link" the database entries for Ernest Hemingway and the books he wrote
     * (The Sun Also Rises, A Farewell to Arms, For Whom the Bell Tolls, The Old Man and the Sea).
     * @return Success/failure message
     */
    @GetMapping("/update-models")
    public String updateModels() {
        boolean success = updaterService.doUpdates();
        return success
            ? "Successfully updated Ernest Hemingway with his books"
            : "Failed to update...";
    }

}
