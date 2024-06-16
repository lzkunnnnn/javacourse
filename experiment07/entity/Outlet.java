package com.experiments.experiment07.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Outlet {
    private String name;
    private List<Ticket> tickets = new LinkedList<>();
    private Random random = new Random();


    public Outlet(String name){
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Ticket sell(){
        Ticket ticket = null;
        try {
            Thread.sleep(random.nextInt(50));
            ticket = Department.getTicket();
            if(ticket != null){
                tickets.add(ticket);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ticket;
    }

    public int getCount(){
        return tickets.size();
    }
}
