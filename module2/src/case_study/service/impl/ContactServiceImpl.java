package case_study.service.impl;

import case_study.model.Booking;
import case_study.model.Contract;
import case_study.service.ContactService;

import java.util.Scanner;
import java.util.TreeSet;

public class ContactServiceImpl implements ContactService {
    private static Scanner scanner=new Scanner(System.in);
    private static TreeSet<Contract>contracts=new TreeSet<>();
    static {
        contracts.add(new Contract("12",BookingServiceImpl.treeSet.first().getMaBooking(), 13000, 788878.0,"MA"));

    }

    @Override
    public void add() {
//        System.out.println("Nhập số hợp đồng: ");
//        String soHopDong=scanner.nextLine();
//        for (int i = 0; i < ; i++) {
//
//        }
    }

    @Override
    public void display() {

    }
}
