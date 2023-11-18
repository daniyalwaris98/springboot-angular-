package com.example.Java.backend.services;

import com.example.Java.backend.dao.CartItemRepository;
import com.example.Java.backend.dao.ExcursionRepository;
import com.example.Java.backend.dao.VacationRepository;
import com.example.Java.backend.dto.CartDTO;
import com.example.Java.backend.dto.CartItemDTO;
import com.example.Java.backend.dto.CartRequestDTO;
import com.example.Java.backend.entities.Cart;
import com.example.Java.backend.entities.CartItem;
import com.example.Java.backend.entities.Customer;
import com.example.Java.backend.entities.Excursion;
import com.example.Java.backend.entities.StatusType;
import com.example.Java.backend.entities.Vacation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

@Service
public class CheckoutServiceImp implements CheckoutService {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartItemService cartItemService;

   @Autowired
   private VacationRepository vacationRepository;

   @Autowired
   private ExcursionRepository excursionRepository;

   @Autowired
   private CartItemRepository cartItemRepository;

 
    public String processCheckout(CartRequestDTO cartRequestDTO) {
        Customer customer = customerService.getCustomerById(cartRequestDTO.getCustomer().getId());
        Cart cart = mapToEntity(cartRequestDTO.getCart());
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setCustomer(customer);
        cartService.createCart(cart);

        List<CartItemDTO> items = cartRequestDTO.getCartItems();
          if(items.isEmpty())
            {
                return "no vacation selected";
            }
        for (CartItemDTO item : items) {
            Vacation vacation = vacationRepository.findById(item.getVacation().getId()).orElse(null);
   
                CartItem cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setVacation(vacation);
                cartItem.setCreateDate(new Date());
                cartItem.setLastUpdate(new Date());
                cartItemService.createCartItem(cartItem);

                Set<Excursion> excursions = item.getExcursions();
                for (Excursion excursion : excursions) {
                   Excursion newExcursion = excursionRepository.findById(excursion.getId()).orElse(null);
                   CartItem newCartItem = cartItemRepository.findById(cartItem.getId()).orElse(null);
                   newCartItem.getExcursions().add(newExcursion);
                   newExcursion.getCartItems().add(newCartItem);
                   cartItemRepository.save(newCartItem);
                   
                }
        }
        return orderTrackingNumber;
    }
    public String generateOrderTrackingNumber() {
        // Use a prefix or any other format you prefer
        String prefix = "ORD";
        
        // Get the current timestamp
        long timestamp = System.currentTimeMillis();
        
        // Format the timestamp as a string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timestampStr = dateFormat.format(new Date(timestamp));
        
        // Concatenate the prefix and timestamp
        String orderTrackingNumber = prefix + timestampStr;
        
        return orderTrackingNumber;
    }

    private Cart mapToEntity(CartDTO cartDTO) {

        Cart cart = new Cart();
        cart.setPackagePrice(cartDTO.getPackage_price());
        cart.setPartySize(cartDTO.getParty_size().intValue());
        cart.setStatus(StatusType.pending);
        cart.setCreateDate(new Date());
        cart.setLastUpdate(new Date());

        return cart;
    }
}
