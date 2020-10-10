package ru.dexsys;

public class App {
    public static void main(String[] args) {

        PetRequest.addPet();

        PetRequest.findPetById(1782);

        PetRequest.updatePet();

        //PetRequest.findPetByStatus(PetStatus.sold);

        PetRequest.deletePet(1802);
    }
}

