Feature: Register cermati account

  Background: I go to register page
    Given User go to path "/gabung"
    Then User validate in register page

  Scenario: Happy Flow Register account
    Given User fill email with "rifky.r@test.com"
    And User fill No Handphone "085678987654"
    And User fill Kata Sandi "FIrky1324."
    And User fill ulangi kata sandi "FIrky1324."
    And User fill Nama Depan "riprip"
    And User fill Nama Belakang "rmdhn"
    And User fill Kota "Kota Malang"
    When User check persetujuan
    Then User click button Daftar




  #https://www.cermati.com