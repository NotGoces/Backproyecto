package com.example.proyectoback.Controller;

import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Servicios.ChipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chip")
public class ChipController {

    private final ChipService chipService;

    @GetMapping("/all")
    public List<Chip> getChip() {
        return (chipService.chips());
    }

}
