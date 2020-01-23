package com.caseStudy.Ecommerce.controller;

import com.caseStudy.Ecommerce.exception.resourcenotfoundexception;
import com.caseStudy.Ecommerce.modal.items;
import com.caseStudy.Ecommerce.repository.itemrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class itemcontroller {

@Autowired
    itemrepository it;
    @GetMapping("/prodetails")
public List<items> getAlldetails()
    {
        return it.findAll();
    }
    @PostMapping("/details")

        public items createNewItem(@Valid @RequestBody items ifc)
        {
            return it.save(ifc);
        }
   @GetMapping("/prodetails/{id}")
    public items getNoteById(@PathVariable(value = "id") Long noteId) {
        return   it.findById(noteId)
                .orElseThrow(() -> new resourcenotfoundexception("Note", "id", noteId));
    }
   @GetMapping("/productname/{name}")
    public List<items> getbyname(@PathVariable(value = "name") String name) {
        return it.findByName(name);

    }
    @GetMapping("/productcat/{category}")
    public List<items> getbycat(@PathVariable(value = "category") String category) {
        return it.findByCategory(category);

    }
    @GetMapping("/productcat/{category}/{price1}/{price2}")
    public List<items> getbycat1(@PathVariable(value = "category") String category,@PathVariable(value = "price1") double p1,@PathVariable(value = "price2") double p2) {
        return it.findByCategoryAndPriceBetween(category,p1,p2);

    }
    @GetMapping("/product1/{price1}/between/{price2}")
    public List<items> getpricera(@PathVariable(value = "price1") double p1,@PathVariable(value = "price2") double p2) {
        return it.findByPriceBetween(p1,p2);

    }
    @PatchMapping("/notes/{id}")
    public items updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody items noteDetails) {

        items note = it.findById(noteId)
                .orElseThrow(() -> new resourcenotfoundexception("Note", "id", noteId));

      note.setCategory(noteDetails.getCategory());
       /* note.setSubCategory(noteDetails.getSubCategory());
        note.setActive(noteDetails.getActive());*/
      //  note.setPrice(noteDetails.getPrice());
      //  note.setDetails(noteDetails.getDetails());
        note.setImage(noteDetails.getImage());
     //  note.setName(noteDetails.getName());
      /*  note.setDetails(noteDetails.getDetails());*/
        items updatedNote = it.save(note);
        return updatedNote;
    }
    @PostMapping("/createproduct")
    public items createproduct(@Valid @RequestBody items item)
    {
        return it.save(item);
    }
    @PutMapping("/editproduct/{id}")
    public items editproduct(@PathVariable(value="id") Long productid,@Valid @RequestBody items item)
    {
        items prod=it.findById(productid).get();
      /*  prod.setName(item.getName());
        prod.setPrice(item.getPrice());
        prod.setCategory(item.getCategory());
        prod.setDetails(item.getDetails());*/
        return it.save(item);

    }

    }

