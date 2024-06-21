package com.library.controller.admin;

import com.library.dto.admin._normal.WishlistDTO;
import com.library.service.admin.AcquisitionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/BuyBook")
public class AcquisitionRequestController {

    private final AcquisitionRequestService acquisitionRequestService;

    @Autowired
    public AcquisitionRequestController(AcquisitionRequestService acquisitionRequestService) {
        this.acquisitionRequestService = acquisitionRequestService;
    }

    @GetMapping("/all")
    public List<WishlistDTO> getAllAcquisition() {
        return acquisitionRequestService.allAcquisitionManage();
    }

    @GetMapping("/title/{title}")
    public List<WishlistDTO> getAcquisitionByTitle(@PathVariable String title) {
        return acquisitionRequestService.findAcquisitionByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<WishlistDTO> getAcquisitionByAuthor(@PathVariable String author) {
        return acquisitionRequestService.findAcquisitionByAuthor(author);
    }

    @GetMapping("/genre/{genre}")
    public List<WishlistDTO> getAcquisitionByGenre(@PathVariable String genre) {
        return acquisitionRequestService.findAcquisitionByGenre(genre);
    }

    @PostMapping("/accept/{requestId}")
    @ResponseBody
    public WishlistDTO acceptAcquisition(@PathVariable int requestId) {
        return acquisitionRequestService.acceptsAcquisition(requestId);
    }

    @PostMapping("/delete/{requestId}")
    @ResponseBody
    public WishlistDTO deleteAcquisition(@PathVariable int requestId) {
        return acquisitionRequestService.deleteAcquisition(requestId);
    }
}
