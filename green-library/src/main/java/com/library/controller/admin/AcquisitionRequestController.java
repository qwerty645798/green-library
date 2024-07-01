package com.library.controller.admin;

import com.library.dto.admin._normal.WishlistDTO;
import com.library.service.admin.AcquisitionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    //    검색
    @GetMapping("/search")
    public ResponseEntity<List<WishlistDTO>> searchBooks(
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword", required = false) String searchKeyword,
            @RequestParam(value = "completeKind", required = false) String completeKind) {

        List<WishlistDTO> wishBooks;

        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            wishBooks = acquisitionRequestService.allAcquisitionManage();
        } else {
            wishBooks = switch (searchType) {
                case "title" -> acquisitionRequestService.findAcquisitionByTitle(searchKeyword);
                case "author" -> acquisitionRequestService.findAcquisitionByAuthor(searchKeyword);
                case "publish" -> acquisitionRequestService.findAcquisitionByPublish(searchKeyword);
                default -> acquisitionRequestService.findAcquisitionByTotal(searchKeyword);
            };
        }

        if (completeKind != null && !completeKind.equals("all")) {
            wishBooks = filterByCompleteKind(wishBooks, completeKind);
        }

        return ResponseEntity.ok(wishBooks);
    }

    private List<WishlistDTO> filterByCompleteKind(List<WishlistDTO> wishBooks, String completeKind) {
        List<WishlistDTO> filteredList = new ArrayList<>();
        System.out.println(filteredList.getClass());
//        complete null error
        for (WishlistDTO book : wishBooks) {
            Character complete = book.getComplete();
//char type
            switch (completeKind.toLowerCase()) {
                case "wait":
                    if (complete.equals('W')) {
                        filteredList.add(book);
                    }
                    break;
                case "accept":
                    if (complete.equals('Y')) {
                        filteredList.add(book);
                    }
                    break;
                case "refuse":
                    if (complete.equals('N')) {
                        filteredList.add(book);
                    }
                    break;
            }
        }

        return filteredList;
    }


    //    승인
    @PostMapping("/acceptBooks")
    public ResponseEntity<String> acceptBooks(@RequestBody List<String> bookIds) {
        acquisitionRequestService.acceptsAcquisition(bookIds);
        return ResponseEntity.ok("승인");
    }

    //    거부
    @PostMapping("/refuseBooks")
    public ResponseEntity<String> refuseBooks(@RequestBody List<String> bookIds) {
        acquisitionRequestService.deleteAcquisition(bookIds);
        return ResponseEntity.ok("거부 승인");
    }
}
