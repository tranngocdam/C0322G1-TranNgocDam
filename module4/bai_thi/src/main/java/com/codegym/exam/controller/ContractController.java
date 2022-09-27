package com.codegym.exam.controller;

import com.codegym.exam.dto.ContractDto;
import com.codegym.exam.model.Contract;
import com.codegym.exam.model.Room;
import com.codegym.exam.service.IContractService;
import com.codegym.exam.service.IRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IRoomService iRoomService;

    @GetMapping("/contract")
    public String goContractList(Model model) {
        List<Contract> contractList = this.iContractService.findAll();
        model.addAttribute("contractList", contractList);
        return "list";
    }

    @GetMapping("/contract/create")
    public String goCreateContract(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("roomList", iRoomService.getAllRoom());
        return "create";
    }

    @PostMapping("/contract/create")
    public String saveContract(@Valid @ModelAttribute("contractDto") ContractDto contractDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.iContractService.save(contract);
        this.iRoomService.setStatus(contract.getRoom().getRoomCode());
        redirectAttributes.addFlashAttribute("message", "Add new success");
        return "redirect:/contract";
    }

    @GetMapping("/contract/delete/{contractCode}")
    public String deleteContract(@PathVariable String contractCode, RedirectAttributes redirectAttributes) {
        Contract contract = this.iContractService.findById(contractCode);
        this.iRoomService.updateStatus(contract.getRoom().getId());
        this.iContractService.delete(contractCode);
        redirectAttributes.addFlashAttribute("message", "Delete success");
        return "redirect:/contract";
    }
}
