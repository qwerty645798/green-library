package com.library.controller.admin;

import com.library.dto.admin._normal.WishlistDTO;
import com.library.service.admin.AcquisitionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AcquisitionRequestController {

    private final AcquisitionRequestService acquisitionRequestService;

    @Autowired
    public AcquisitionRequestController(AcquisitionRequestService acquisitionRequestService) {
        this.acquisitionRequestService = acquisitionRequestService;
    }

    @GetMapping("/BuyBook")
    public String buy(Model model) {
        List<WishlistDTO> wishList = acquisitionRequestService.allAcquisitionManage();
        model.addAttribute("wishList", wishList);
        return "admin/adminBook/buyBook/bookBuy";
    }

    @GetMapping("/searchWishlist")
    public String searchWishlist(@RequestParam(value = "searchType", required = false) String searchType,
                                 @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
                                 @RequestParam(value = "perPage", required = false) Optional<Integer> perPage,
                                 Model model) {
        int itemsPerPage = perPage.orElse(10); // Default to 10 if not specified

        List<WishlistDTO> wishList;
        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            wishList = acquisitionRequestService.allAcquisitionManage();
        } else {
            switch (searchType) {
                case "title":
                    wishList = acquisitionRequestService.findAcquisitionByTitle(searchKeyword);
                    break;
                case "author":
                    wishList = acquisitionRequestService.findAcquisitionByAuthor(searchKeyword);
                    break;
                case "genre":
                    wishList = acquisitionRequestService.findAcquisitionByGenre(searchKeyword);
                    break;
                default:
                    wishList = acquisitionRequestService.allAcquisitionManage();
                    break;
            }
        }

//        int totalWishlistCount = acquisitionRequestService.getTotalWishlistCount();

        model.addAttribute("wishList", wishList);
//        model.addAttribute("totalWishlistCount", totalWishlistCount);
        model.addAttribute("perPage", itemsPerPage);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchKeyword", searchKeyword);

        return "admin/adminBook/buyBook/bookBuy";
    }
}
