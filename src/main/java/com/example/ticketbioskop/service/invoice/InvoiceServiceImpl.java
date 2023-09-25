package com.example.ticketbioskop.service.invoice;

import com.example.ticketbioskop.entity.AppFilm;
import com.example.ticketbioskop.entity.AppSchedule;
import com.example.ticketbioskop.entity.seat.AppSeat;
import com.example.ticketbioskop.entity.user.AppUser;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    public byte[] generateInvoice(AppUser user, AppSeat seat, AppFilm film, AppSchedule schedule) {
        try {
            // Load the compiled .jasper file
            JasperReport report = JasperCompileManager.compileReport("path_to_your_report.jrxml");

            // Fill the report with data
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("USER_NAME", user.getUsername());
            parameters.put("FILM_NAME", film.getFilm_name());
            parameters.put("SEAT_NUMBER", seat.getNomor_kursi());
            parameters.put("FILM_SCHEDULE", schedule.getTanggal_tayang());
            // ... add other parameters as needed

            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

            // Export to PDF
            return JasperExportManager.exportReportToPdf(print);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate invoice", e);
        }
    }

}

