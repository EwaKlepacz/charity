//package pl.coderslab.charity.web.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import pl.coderslab.charity.model.entities.Institution;
//import pl.coderslab.charity.model.repositories.InstitutionRepostiory;
//
//@Controller
//@RequestMapping("/institustion")
//public class InstitutionControllers {
//
//    private InstitutionRepostiory institutionRepostiory;
//
//    public InstitutionControllers(InstitutionRepostiory institutionRepostiory){
//        this.institutionRepostiory = institutionRepostiory;
//    }
//
//    @GetMapping({"/add", "edit"})
//    public String prepareManageInstitutionPage(@RequestParam(required = false) Long id, Model model) {
//        Institution institution = new Institution();
//        if (id != null) {
//            institution = institutionRepostiory.findById(id).orElse(new Institution());
//        }
//
//        model.addAttribute("instituiton", institution);
//        return "institution/manage";
//    }
//}
//
//
//
////
////    @PostMapping({"/add", "edit"})
////    public String processManageRecipePage(@Valid Recipe recipe) {
////        User user = userRepository.findById(1L).orElse(null);
////        recipe.setAuthor(user);
////        recipeRepository.save(recipe);
////
//////        RetingAndNote ratingAndNote = new RetingAndNote();
//////        ratingAndNote.setRecipe(recipe);
//////        ratingAndNote.setUser(user);
//////        ratingAndNote.setRating(0.0);
//////        retingAndNoteRepository.save(ratingAndNote);
////
////        return "redirect:/";
////    }
////
////    @GetMapping("/remove")
////    public String prepareRemoveRecipePage(Long id, Model model) {
////
////        if (id != null) {
////            Recipe recipe = recipeRepository.findById(id).orElse(new Recipe());
////            model.addAttribute("recipeToRemove", recipe);
////            return "recipe/remove";
////        }
////        return "redirect:/";
////    }
////
////    @PostMapping("/remove")
////    public String processRemoveAuthorPage(Recipe recipe) {
////        if (recipe.getId() != null) {
////            recipe = recipeRepository.findById(recipe.getId()).orElse(new Recipe());
////            recipeRepository.delete(recipe);
////        }
////        return "redirect:/";
////    }
////
////    @GetMapping("/details")
////    public String prepareDetailsPage(@RequestParam(required = false) Long id, Model model) {
////        Recipe newRecipe = recipeRepository.findById(id).orElse(new Recipe());
////        model.addAttribute("recipe", newRecipe);
////        return "recipe/details";
////    }
////
////    @GetMapping("/list")
////    public String prepareListPage(@RequestParam(required = false) Long id, Model model) {
////        model.addAttribute("recipelist", recipeRepository.findByCategoryId(id));
////        Category category = categoryRepository.findById(id).orElse(new Category());
////        model.addAttribute("section", category);
////        return "recipe/list";
////    }
////
////    @GetMapping("/tag")
////    public String prepareTagPage(@RequestParam(required = false) Long id, Model model) {
////        model.addAttribute("recipelist", recipeRepository.findByTagId(id));
////        Tag tag = tagRepository.findById(id).orElse(new Tag());
////        model.addAttribute("section", tag);
////        return "recipe/list";
////    }
////}