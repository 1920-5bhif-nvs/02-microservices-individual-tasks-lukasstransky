package at.htl.starbucks.models;

import javax.enterprise.inject.Model;

@Model
public class Roaster {

    public Coffee roast(){
        return new Coffee("juggy", true);
    }
}

