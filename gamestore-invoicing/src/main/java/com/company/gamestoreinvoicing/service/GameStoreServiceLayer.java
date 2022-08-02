package com.trilogyed.gamestore.service;

import com.company.gamestoreinvoicing.model.Console;
import com.company.gamestoreinvoicing.model.Invoice;
import com.company.gamestoreinvoicing.repository.InvoiceRepository;
import com.company.gamestoreinvoicing.repository.ProcessingFeeRepository;
import com.company.gamestoreinvoicing.repository.TaxRepository;
import com.company.gamestoreinvoicing.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Component
public class GameStoreServiceLayer {
    private long id;
    @NotEmpty(message = "T-Shirt size is required")
    private String size;
    @NotEmpty(message = "T-Shirt color is required")
    private String color;
    @NotEmpty(message = "T-Shirt description is required")
    private String description;
    @NotNull(message = "T-Shirt price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Min Price is $0.0")
    @DecimalMax(value = "999.99", inclusive = true, message = "Max Price is $999.99")
    private BigDecimal price;
    @NotNull(message = "T-Shirt quantity is required")
    @Min(value = 1, message = "Min Quantity 1")
    @Max(value = 50000, message = "Max Quantity is 50,000")
    private long quantity;
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    InvoiceRepository invoiceRepo;
    TaxRepository taxRepo;
    ProcessingFeeRepository processingFeeRepo;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirtViewModel that = (TShirtViewModel) o;
        return getId() == that.getId() &&
                getQuantity() == that.getQuantity() &&
                Objects.equals(getSize(), that.getSize()) &&
                Objects.equals(getColor(), that.getColor()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSize(), getColor(), getDescription(), getPrice(), getQuantity());
    }

    public List<InvoiceViewModel> getInvoicesByCustomerName(String name) {
        List<com.company.gamestoreinvoicing.model.Invoice> invoiceList = invoiceRepo.findByName(name);
        List<InvoiceViewModel> ivmList = new ArrayList<>();
        List<InvoiceViewModel> exceptionList = null;
        return ivmList;
    }

    public List<InvoiceViewModel> getAllInvoices() {
        List<Invoice> listInvoice = invoiceRepo.findAll();
        return listInvoice;
    }

    public InvoiceViewModel getInvoice(long invoiceId) {
    }

    public InvoiceViewModel createInvoice(InvoiceViewModel invoiceViewModel) {
    }
}