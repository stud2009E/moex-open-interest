package pub.ta.open.interest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pub.ta.open.interest.entity.MoexData;
import pub.ta.open.interest.exception.MoexException;
import pub.ta.open.interest.service.MoexService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/MOEX")
@RequiredArgsConstructor
public class MoexController {
    private final MoexService service;
    @GetMapping(value = "/first-get/{futures}")
    public void firstSave(@PathVariable("futures") String futures) throws MoexException {
        service.firstSave(futures);
    }
    @GetMapping(value = "/{futures}")
    public List<MoexData> getByFutures(@PathVariable("futures") String futures){
         return service.getByFutures(futures);
    }
    @GetMapping(value = "/from/{futures}/{date}")
    public List<MoexData> getByFuturesFromDate(@PathVariable("futures") String futures, @PathVariable("date") LocalDate date){
        return service.getByFutures(futures, date);
    }
}