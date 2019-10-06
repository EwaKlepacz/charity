//package pl.coderslab.charity.web.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import pl.coderslab.charity.model.entities.Category;
//import pl.coderslab.charity.model.repositories.CategoryRepository;
//
//import javax.validation.Valid;
//import java.awt.print.Book;
//import java.util.List;
//
//@Controller
//@RequestMapping("/category")
//public class CategoryControllers {
//
//    private CategoryRepository categoryRepository;
//
//    public CategoryControllers(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//        @GetMapping({"/add", "edit"})
//    public String prepareManageCategoryPage(@RequestParam(required = false) Long id, Model model) {
//        Category category = new Category();
//        if (id != null) {
//            category = categoryRepository.findById(id).orElse(new Category());
//        }
//
//        model.addAttribute("category", category);
//        return "category/manage";
//    }
//        @PostMapping({"/add", "edit"})
//    public String processManageCategoryPage(@Valid Category category ) {
//            Category category = categoryRepository.findById(1L).orElse(null);
//            category.setName(name);
//
//            return "redirect:/";
//        }
//
//
//        @GetMapping("/remove")
//    public String prepareRemoveCategoryPage(Long id, Model model) {
//
//        if (id != null) {
//            Category category  = categoryRepository.findById(id).orElse(new Category());
//            model.addAttribute("categoryToRemove", category);
//            return "category/remove";
//        }
//        return "redirect:/";
//    }
//        @PostMapping("/remove")
//    public String processRemoveCategoryPage(Category category) {
//        if (category.getId() != null) {
//            category = categoryRepository.findById(category.getId()).orElse(new Category());
//            categoryRepository.delete(category);
//        }
//        return "redirect:/";
//    }
//}
//
//
