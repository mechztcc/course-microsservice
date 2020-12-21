package com.example.hrpayrool.services;

import com.example.hrpayrool.entities.Payment;
import com.example.hrpayrool.entities.Worker;
import com.example.hrpayrool.feignclients.WorkerFeignClient;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
