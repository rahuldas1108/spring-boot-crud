package com.example.springbootcrud.controller;

import com.example.springbootcrud.dto.CategoryHierarchy;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cost")
public class GroupingByController {

        @PostMapping("/getAll")
        public void getAllCatagoryDetails(@RequestBody List<CategoryHierarchy> categoryHierarchy){

            System.out.println("print the input : "+categoryHierarchy);

            Map<String, List<CategoryHierarchy>> groupByCategoryCode=categoryHierarchy.stream().collect(Collectors.groupingBy(CategoryHierarchy::getCategoryCode));
            System.out.println("GroupByCategoryCode : "+groupByCategoryCode);

            Map<String, Set<String>> groupByCategoryCode1=categoryHierarchy.stream().
                   collect(Collectors.groupingBy(CategoryHierarchy::getCategoryCode,Collectors.mapping(
                           CategoryHierarchy::getSubCategoryCode,Collectors.toSet()
                           )
                   ));
            System.out.println("CategoryCode and SubCategoryCode : "+groupByCategoryCode1);

            Map<String, Set<String>> groupByCategoryCode11=categoryHierarchy.stream().
                    collect(Collectors.groupingBy(CategoryHierarchy::getCategoryCode,Collectors.mapping(
                                    CategoryHierarchy::getItemTypeCode,Collectors.toSet()
                            )
                    ));
            System.out.println("CategoryCode and itemtypecode : "+groupByCategoryCode11);

            Map<String, String> CategoryMap= categoryHierarchy.stream().distinct().collect(Collectors.toMap(
                    cc->cc.getCategoryCode(),cd->cd.getCategoryDesc(),(oldValue,newValue)-> newValue
            ));
            System.out.println("CategoryCode and categoryDesc : "+CategoryMap);

            Map<String, Set<String>> CategoryMap1= categoryHierarchy.stream().collect(Collectors.groupingBy(
                    CategoryHierarchy::getCategoryCode,
                    Collectors.mapping(
                            CategoryHierarchy::getCategoryDesc, Collectors.toSet()
                    )
            ));
            System.out.println("CategoryCode and categoryDesc groupingBy : "+CategoryMap1);

            Map<String, String> CategoryMap2= categoryHierarchy.stream().collect(Collectors.toMap(
                    c->c.getCategoryCode().concat(c.getSubCategoryCode()),c->c.getSubCategoryDesc(),(oldValue,newValue)-> newValue
            ));
            System.out.println("map of cc,subcc,subcD  : "+CategoryMap2);

            Map<String, Map<String,Set<String>>> groupByCategoryCode2=
            categoryHierarchy.stream().
                    collect(Collectors.groupingBy(
                            CategoryHierarchy::getCategoryCode,
                            Collectors.groupingBy(
                                    CategoryHierarchy::getSubCategoryCode,
                                    Collectors.mapping(
                                            CategoryHierarchy::getSubCategoryDesc,
                                            Collectors.toSet()
                                    )
                            )
                    ));
            System.out.println("map of cc,subcc,subcD groupingBy : "+groupByCategoryCode2);

            Map<String, Map<String,Set<String>>> groupByCategoryCode3=
                    categoryHierarchy.stream().
                            collect(Collectors.groupingBy(
                                    CategoryHierarchy::getCategoryCode,
                                    Collectors.groupingBy(
                                            CategoryHierarchy::getItemTypeCode,
                                            Collectors.mapping(
                                                    CategoryHierarchy::getItemTypeDesc,
                                                    Collectors.toSet()
                                            )
                                    )
                            ));
            System.out.println("map of cC,itC,itD : "+groupByCategoryCode3);
            System.out.println("find by 3pp till item desc : "+ groupByCategoryCode3.get("3PP/LICENSE").get("HIGH EMB BAG"));
            System.out.println("find by asscessories till item desc : "+ groupByCategoryCode3.get("ACCESSORIES").get("HIGH EMB BAG"));
          //  Map<String,String> categoryMap= categoryHierarchy.stream().collect(Collectors.toMap(CategoryHierarchy::getCategoryCode,CategoryHierarchy::getCategoryDesc));
            Map<String,String> categoryMap=xxx(categoryHierarchy);
            System.out.println("normal map: "+categoryMap);
               //return (List<CategoryHierarchy>) groupByCategoryCode;


        }
        public Map<String, String> xxx(List<CategoryHierarchy> categoryHierarchy){
            Map<String , String> fgh= new HashMap<>();
            for(CategoryHierarchy c : categoryHierarchy){
                fgh.put(c.getCategoryCode(),c.getCategoryDesc());
            }
            return fgh;
        }

}
