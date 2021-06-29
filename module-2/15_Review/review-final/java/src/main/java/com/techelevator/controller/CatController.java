package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")

public class CatController {

    private CatCardDao cat;
    private CatFactService catFact;
    private CatPicService catPic;

    public CatController(CatCardDao cat, CatFactService catFact, CatPicService catPic) {
        this.cat = cat;
        this.catFact = catFact;
        this.catPic = catPic;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CatCard getIndividualCard(@PathVariable long id) {
        return cat.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CatCard> getAllCards() {
        return cat.list();
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public CatCard makeNewCard() {

        CatFact f = catFact.getFact();
        CatPic p = catPic.getPic();
        CatCard c = new CatCard();
        c.setCatFact(f.getText());
        c.setImgUrl(p.getFile());
        return c;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void saveNewCard(@Valid @RequestBody CatCard incomingCard) {

        cat.save(incomingCard);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateExistingCard(@Valid @RequestBody CatCard changedCard, @PathVariable long id) {
       cat.update(id, changedCard);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteExistingCard(@PathVariable long id) {
        if(cat.get(id) != null) {
            cat.delete(id);
        }
    }
}