package com.caseStudy.Ecommerce.controller;

import com.caseStudy.Ecommerce.modal.blogs;
import com.caseStudy.Ecommerce.repository.blogrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/blog")
public class blogcontroller {
    @Autowired
    blogrepository br;
    @GetMapping("/getallblogs")
    @ResponseBody
    public ArrayList<blogs> getallblogs() {
        ArrayList<blogs> bloglist = (ArrayList<blogs>) br.findAll();
        Collections.reverse(bloglist);
        // return br.findAll();
        return bloglist;
    }
    @PostMapping("/saveblogs")
    @ResponseBody
    public blogs saveblogs(@Valid @RequestBody blogs bl)
    {
        bl.setDate(new Date());
        return br.save(bl);
    }
    @GetMapping("/getblogs/{id}")
    @ResponseBody
    public blogs getblogsbyid(@PathVariable(value="id") Long id)
    {
        return br.findById(id).get();
    }
   /* @GetMapping("/owner/{owner}")
    @ResponseBody
    public List<blogs> getblogsbyowner(@PathVariable(value="owner") String owner)
    {
        return br.findByOwner(owner);
    }*/
    @GetMapping("/name/{name}")
    @ResponseBody
    public List<blogs> getblogsbyname(@PathVariable(value="name") String name)
    {
        return br.findByBlogname(name);
    }
    @GetMapping("/content/{content}")
    @ResponseBody
    public blogs getblogsbycontent(@PathVariable(value="name") String content)
    {
        return br.findByContent(content);
    }
    @GetMapping("/data/{date}")
    @ResponseBody
    public List<blogs> getblogsbydate(@PathVariable(value="name") Date date)
    {
        return br.findByDate(date);
    }
@PatchMapping("/date/{id}")
    @ResponseBody
    public blogs dateto(/*@Valid @RequestBody blogs bt*/@PathVariable(value="id") Long id)
{
    blogs bs=br.findById(id).get();
    bs.setDate(new Date());
    return br.save(bs);
}




}
