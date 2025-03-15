package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMICal {
    @RequestMapping("/bmi")
    public String Bmi(
            @RequestParam(name = "height", required = false, defaultValue = "0") float height,
            @RequestParam(name = "weight", required = false, defaultValue = "0") float weight,
            ModelMap model) {

        if (weight <= 0 || height <= 0) {
            model.addAttribute("result", "Weight >= 0 && Height >= 0.");
            return "Bmi";
        }

        double bmi = weight / (height * height);
        String category = getBMICategory(bmi);

        model.addAttribute("resultBMI", String.format("%.2f", bmi));
        model.addAttribute("categoryBMI", category);

        return "Bmi";
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal weight";
        else if (bmi < 29.9) return "Overweight";
        else return "Obese";
    }
}
