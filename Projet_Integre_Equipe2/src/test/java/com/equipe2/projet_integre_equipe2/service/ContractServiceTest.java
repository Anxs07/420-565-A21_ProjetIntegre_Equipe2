package com.equipe2.projet_integre_equipe2.service;

import com.equipe2.projet_integre_equipe2.model.*;
import com.equipe2.projet_integre_equipe2.repository.ContractRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContractServiceTest {

    @Mock
    private ContractRepository contractRepository;

    @InjectMocks
    private ContractService contractService;

    private Contract contract;
    private Offer offer;
    private Internship internship;
    private Monitor monitor;
    private Student student;

    @BeforeEach
    void setup() {
        offer = Offer.builder()
                .idOffer(1)
                .companyName("Cegep")
                .address("Montral")
                .salary("19")
                .jobTitle("Developpeur")
                .description("Java")
                .skills("Debrouillard")
                .jobSchedules("Temps plein")
                .workingHours("37.5")
                .monitorEmail("cegep@email.com")
                .isValid(false)
                .state("Invalide")
                .displayDate("2021-10-15")
                .deadlineDate("2021-10-30")
                .startInternshipDate("2021-10-30")
                .endInternshipDate("2021-12-30")
                .build();

        monitor = Monitor.monitorBuilder()
                .password("toto")
                .lastName("toto")
                .firstName("toto")
                .companyName("toto")
                .email("toto@toto.toto")
                .build();

        student = Student.studentBuilder()
                .id(1)
                .firstName("Toto")
                .lastName("Tata")
                .matricule("1234567")
                .password("1234")
                .isCvValid(true)
                .build();

        internship = Internship.builder()
                .isSignedByStudent(true)
                .isSignedByMonitor(true)
                .offer(offer)
                .student(student)
                .build();

        contract = Contract.builder()
                .idContract(1)
                .internship(internship)
                .collegeResponsability("Faire ceci")
                .companyResponsability("Faire des evaluation")
                .studentResponsability("Montrer la capaciter")
                .studentSignature("Signature student")
                .monitorSignature("Signature monitor")
                .adminSignature("Signature admin")
                .signatureDateStudent("2021-10-25")
                .signatureDateMonitor("2021-10-25")
                .signatureDateAdmin("2021-10-25")
                .build();
    }

    @Test
    public void testSaveContract() {
        when(contractRepository.save(contract)).thenReturn(contract);
        Optional<Contract> actualContract = contractService.saveContract(contract);
        assertThat(actualContract.get()).isEqualTo(contract);
    }

    @Test
    public void testSaveContractFails() {
        when(contractRepository.save(contract)).thenReturn(null);
        Optional<Contract> actualContract = contractService.saveContract(contract);
        assertThat(actualContract).isEmpty();
    }

    @Test
    public void testGetContractByStudent_Id() {
        when(contractRepository.saveAll(getListOfContracts())).thenReturn(getListOfContracts());
        when(contractRepository.findContractByInternship_Student_Id(student.getId())).thenReturn(getListOfContracts());
        final Optional<List<Contract>> expectedContract = Optional.of(contractRepository.saveAll(getListOfContracts()));
        final Optional<List<Contract>> contract = contractService.getContractByStudentId(student.getId());
        assertThat(contract.get().size()).isEqualTo(expectedContract.get().size());
    }

    @Test
    public void testGetContractByStudent_IdFails() {
        when(contractRepository.saveAll(getListOfContracts())).thenReturn(getListOfContracts());
        when(contractRepository.findContractByInternship_Student_Id(student.getId())).thenReturn(null);
        contractRepository.saveAll(getListOfContracts());
        final Optional<List<Contract>> contract = contractService.getContractByStudentId(student.getId());
        assertThat(contract).isEqualTo(Optional.empty());
    }

    private List<Contract> getListOfContracts() {
        List<Contract> contractList = new ArrayList<>();
        contractList.add(Contract.builder()
                .internship(internship)
                .collegeResponsability("test")
                .companyResponsability("tester")
                .studentResponsability("tdd")
                .studentSignature("signatureStudent")
                .monitorSignature("signatureMonitor")
                .adminSignature("signatureAdmin")
                .signatureDateStudent("2021-10-25")
                .signatureDateMonitor("2021-10-25")
                .signatureDateAdmin("2021-10-25")
                .build());
        contractList.add(Contract.builder()
                .internship(internship)
                .collegeResponsability("Faire travail")
                .companyResponsability("Bien faire")
                .studentResponsability("Conception")
                .studentSignature("signatureStudent")
                .monitorSignature("signatureMonitor")
                .adminSignature("signatureAdmin")
                .signatureDateStudent("2021-10-25")
                .signatureDateMonitor("2021-10-25")
                .signatureDateAdmin("2021-10-25")
                .build());
        contractList.add(Contract.builder()
                .internship(internship)
                .collegeResponsability("Clean Code")
                .companyResponsability("Algorithme")
                .studentResponsability("Respecter critere")
                .studentSignature("signatureStudent")
                .monitorSignature("signatureMonitor")
                .adminSignature("signatureAdmin")
                .signatureDateStudent("2021-10-25")
                .signatureDateMonitor("2021-10-25")
                .signatureDateAdmin("2021-10-25")
                .build());
        return  contractList;
    }
}