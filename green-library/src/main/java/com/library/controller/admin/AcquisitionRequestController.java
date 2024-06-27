package com.library.controller.admin;

import com.library.dto.admin._normal.WishlistDTO;
import com.library.service.admin.AcquisitionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/BuyBook")
public class AcquisitionRequestController {

    private final AcquisitionRequestService acquisitionRequestService;

    @Autowired
    public AcquisitionRequestController(AcquisitionRequestService acquisitionRequestService) {
        this.acquisitionRequestService = acquisitionRequestService;
    }

    @GetMapping()
    public String buy(Model model) {
        List<WishlistDTO> wishList = acquisitionRequestService.allAcquisitionManage();
        model.addAttribute("wishList", wishList);
        return "admin/adminBook/buyBook/bookBuy";
    }

    @GetMapping("/search")
    public ResponseEntity<List<WishlistDTO>> searchBooks(
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword) {

        List<WishlistDTO> books;

        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            books = acquisitionRequestService.allAcquisitionManage();
        } else {
            books = switch (searchType) {
                case "title" -> acquisitionRequestService.findAcquisitionByTitle(searchKeyword);
                case "author" -> acquisitionRequestService.findAcquisitionByAuthor(searchKeyword);
                case "genre" -> acquisitionRequestService.findAcquisitionByGenre(searchKeyword);
                default -> acquisitionRequestService.findAcquisitionByTotal(searchKeyword);
            };
        }
        return ResponseEntity.ok(books);
    }
}
