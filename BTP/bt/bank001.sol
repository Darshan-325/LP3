// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
 
contract BankAccount {
    uint public balance;
 
    constructor() payable {
        balance = msg.value;
    }
 
    function deposit() public payable {
        require(msg.value > 0, "Amount must be greater than zero");
        balance += msg.value;
    }
 
    function withdraw(uint amount) public {
        require(balance >= amount, "Not enough balance");
        balance -= amount;
        payable(msg.sender).transfer(amount);
    }
 
    function getBalance() public view returns (uint) {
        return balance;
    }
}

