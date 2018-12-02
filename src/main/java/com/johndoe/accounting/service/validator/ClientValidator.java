package com.johndoe.accounting.service.validator;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
import com.johndoe.accounting.service.request.ClientRequest;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by nebil on 12/2/18.
 */
public class ClientValidator {

    private ClientRequest clientRequest;
    StringBuilder exceptionMessages = new StringBuilder();

    public ClientValidator(ClientRequest clientRequest){
        this.clientRequest = clientRequest;
    }

    private void validateFirstName()throws InvalidClientInputException{
        try {
            if (clientRequest.getType().equals("Individual") &&(!clientRequest.getFirstName().matches("[a-zA-Z]+")) ) {
                throw new InvalidClientInputException("Invalid input for first name");
            }
        }
        catch (InvalidClientInputException exception){
            exceptionMessages.append(exception.getMessage())
            .append(System.getProperty("line.separator"));
        }
    }

    private void validateLastName()throws InvalidClientInputException{
        try {
            if (clientRequest.getType().equals("Individual")&&(!clientRequest.getLastName().matches("[a-zA-Z]+"))) {
                throw new InvalidClientInputException("Invalid input for last name");
            }
        }
        catch (InvalidClientInputException exception){
            exceptionMessages.append(exception.getMessage())
            .append(System.getProperty("line.separator"));
        }
    }

    private void validateAge()throws InvalidClientInputException{

        try {
            if(clientRequest.getBirthDate()!=null) {
                Period period = Period.between(clientRequest.getBirthDate(), LocalDate.now());
                if (period.getYears() < 18) {
                    throw new InvalidClientInputException("Person is underage!");
                }
            }
        }
        catch (InvalidClientInputException exception){
            exceptionMessages.append(exception.getMessage())
            .append(System.getProperty("line.separator"));
        }
    }

    private void validateNumberOfEmployees()throws InvalidClientInputException{
        try {
            if (clientRequest.getType().equals("Business") && clientRequest.getNumberOfEmployee() <= 0) {
                throw new InvalidClientInputException("Number of employees can't be 0 or negative");
            }
        }
        catch (InvalidClientInputException exception){
            exceptionMessages.append(exception.getMessage())
            .append(System.getProperty("line.separator"));
        }
    }

    public void validate()throws InvalidClientInputException{
        validateFirstName();
        validateLastName();
        validateAge();
        validateNumberOfEmployees();
        if(exceptionMessages.length()>0){
            throw new InvalidClientInputException(exceptionMessages.toString().trim());
        }
    }

}
