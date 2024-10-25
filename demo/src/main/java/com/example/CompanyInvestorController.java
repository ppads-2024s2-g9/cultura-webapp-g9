package com.example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class CompanyInvestorController {

    @Autowired
    private CompanyInvestorRepo companyInvestorRepo;

    public CompanyInvestorController() {
    }

    @GetMapping("/api/company-investors")
    Iterable<CompanyInvestor> getCompanyInvestors(@RequestParam Optional<String> lei) {
        return companyInvestorRepo.findAll();
    }

    @GetMapping("/api/company-investors/{id}")
    Optional<CompanyInvestor> getCompanyInvestor(@PathVariable long id) {
        return companyInvestorRepo.findById(id);
    }

    @PostMapping("/api/company-investors")
    CompanyInvestor createCompanyInvestor(@RequestBody CompanyInvestor companyInvestor) {
        return companyInvestorRepo.save(companyInvestor);
    }

    @PutMapping("/api/company-investors/{id}")
    Optional<CompanyInvestor> updateCompanyInvestor(@RequestBody CompanyInvestor companyInvestorRequest, @PathVariable long id) {
        Optional<CompanyInvestor> opt = companyInvestorRepo.findById(id);
        if (opt.isPresent()) {
            if (companyInvestorRequest.getId() == id) {
                return Optional.of(companyInvestorRepo.save(companyInvestorRequest));
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados da empresa investidora com id " + id);
    }

    @DeleteMapping(value = "/api/company-investors/{id}")
    void deleteCompanyInvestor(@PathVariable long id) {
        companyInvestorRepo.deleteById(id);
    }
}
