package com.data.session_09.controller;

import com.data.session_09.model.entity.Seed;
import com.data.session_09.service.ICategoryService;
import com.data.session_09.service.ISeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/seeds")
public class SeedController {
    @Autowired
    private ISeedService seedService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String list(@RequestParam(defaultValue = "1") int page, Model model) {
        int size = 5;
        List<Seed> seeds = seedService.findAll(page, size);
        long total = seedService.countTotal();
        int totalPages = (int) Math.ceil((double) total / size);

        model.addAttribute("seeds", seeds);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "seedList";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("seed", new Seed());
        model.addAttribute("categories", categoryService.findAll());
        return "seedForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("seed") Seed seed) {
        if (seed.getId() == null) {
            seedService.save(seed);
        } else {
            seedService.update(seed);
        }
        return "redirect:/seeds";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("seed", seedService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "seedForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        seedService.delete(id);
        return "redirect:/seeds";
    }
}
