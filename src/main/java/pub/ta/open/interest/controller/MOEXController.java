package pub.ta.open.interest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pub.ta.open.interest.Entity.MOEXData;
import pub.ta.open.interest.service.MOEXServiceImpl;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/MOEX")
public class MOEXController {
    @Autowired
    private MOEXServiceImpl service;

    @GetMapping(value = "/{id}")
    public List<MOEXData> get(@PathVariable("id") String id, Model mode){
         return service.save(id);
        //return Arrays.stream(arrDto).toList();
    }
}