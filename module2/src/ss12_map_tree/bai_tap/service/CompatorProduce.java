package ss12_map_tree.bai_tap.service;

import ss12_map_tree.bai_tap.model.Produce;

import java.util.Comparator;

public class CompatorProduce implements Comparator<Produce> {

    @Override
    public int compare(Produce p1, Produce p2) {
        return p1.getGiaCa()>p2.getGiaCa()?1:-1;
    }
}
