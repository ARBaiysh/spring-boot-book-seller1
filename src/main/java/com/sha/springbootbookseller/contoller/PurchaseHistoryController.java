package com.sha.springbootbookseller.contoller;


import com.sha.springbootbookseller.model.Book;
import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.security.UserPrincipal;
import com.sha.springbootbookseller.service.IBookService;
import com.sha.springbootbookseller.service.IPurchaseHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/purchase-history")
@AllArgsConstructor
public class PurchaseHistoryController {

    private final IPurchaseHistoryService purchaseHistoryService;

    @PostMapping()
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory) {
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllPurchaseOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ResponseEntity.ok(purchaseHistoryService.findPurchaseItemsOfUser(userPrincipal.getId()));
    }
}
