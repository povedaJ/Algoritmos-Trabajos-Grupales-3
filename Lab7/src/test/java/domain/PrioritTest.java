package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrioritTest {
    private PriorityLinkedQueue priorityLinkedQueue;
    @Test
    void enQueue() {
        this.priorityLinkedQueue = util.Utility.getPriorityLinkedQueue();
        try {
            priorityLinkedQueue.enQueue(new Person("jOSS","SAD"),2);
            priorityLinkedQueue.enQueue(new Person("vIVIV","SAD"),1);
            priorityLinkedQueue.enQueue(new Person("mEGAN","Happy"),3);
            System.out.println(priorityLinkedQueue.toString());
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }

    }
}