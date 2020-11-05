package com.milankascomposer.composerapi.controller;

import com.milankascomposer.composerapi.dto.CompanyDTO;
import com.milankascomposer.composerapi.dto.ProductDTO;
import com.milankascomposer.composerapi.service.CompanyClientService;
import com.milankascomposer.composerapi.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/company")
public class CompanyController {

    @Autowired
    ProductClientService productClientService;
    @Autowired
    CompanyClientService companyClientService;

    @GetMapping("/{companyId}/products")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<ProductDTO> getProductsByCompanyId(@Valid @PathVariable(value = "companyId") UUID companyId) {
        CompanyDTO companyStored = this.companyClientService.getCompanyById(companyId);
        return this.productClientService.getProductsByCompanyId(companyStored.getCompanyId());
    }

}
