package ma.emsi.hopital.Web;

import lombok.AllArgsConstructor;
import ma.emsi.hopital.Entities.Patient;
import ma.emsi.hopital.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository PatientRepository;

    @GetMapping("/index")
public String index(Model Model,
                    @RequestParam(name="Page", defaultValue = "0") int P,
                    @RequestParam(name="Size", defaultValue = "4") int S,
                    @RequestParam(name="Keyword", defaultValue = "") String K){

        Page<Patient> PagePatient=PatientRepository.findByNameContains(K,PageRequest.of(P,S));
        Model.addAttribute("Liste Patient",PagePatient.getContent());
        Model.addAttribute("Page", new int[PagePatient.getTotalPages()]);
        Model.addAttribute("CurrentPage",P);
        Model.addAttribute("Keyword",K);
    return "Patient";
}

    @GetMapping("/Delete")
    public String Delete(@RequestParam (
            name="Id") Long Id,
                         @RequestParam(name = "Keyword", defaultValue ="") String Keyword,
                         @RequestParam(name = "Page", defaultValue ="0" ) int Page){
        PatientRepository.deleteById(Id);
        return "redirect:/index?Page="+Page+"&Keyword="+Keyword;
    }

    @GetMapping("/")
    public String Home(){
        return "redirect:/index";
    }
}
