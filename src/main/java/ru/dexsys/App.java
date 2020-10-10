package ru.dexsys;

public class App {
    public static void main(String[] args) {
          /*  PetRequest.addPet(1488, "Lucky", "Test tag - 1");
            PetRequest.findPetById(1488);
            PetRequest.updatePet(1488, "Steven", "New test tag - 2!", PetStatus.sold);
            PetRequest.findPetById(1488);
            PetRequest.deletePet(1488);
            PetRequest.findPetByStatus(PetStatus.sold);
            */

        PetRequest.addPet();

        PetRequest.findPetById(1782);

        PetRequest.updatePet();

        //PetRequest.findPetByStatus(PetStatus.sold);

        PetRequest.deletePet(1802);
    }
}

