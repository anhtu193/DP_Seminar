// 1. Strategy interface
interface PaymentStrategy {
  pay(amount: number): void;
}

// 2. Concrete
class CreditCardPayment implements PaymentStrategy {
  pay(amount: number): void {
      console.log(`Paid ${amount} using credit card`);
  }
}
class PayPalPayment implements PaymentStrategy {
  pay(amount: number): void {
      console.log(`Paid ${amount} using PayPal`);
  }
}

class CashPayment implements PaymentStrategy {
  pay(amount: number): void {
      console.log(`Paid ${amount} using cash`);
  }
}

// 3. Context
class PaymentContext {
  private strategy: PaymentStrategy;

  constructor(strategy: PaymentStrategy) {
      this.strategy = strategy;
  }

  // Setter to allow changing the strategy at runtime
  setStrategy(strategy: PaymentStrategy) {
      this.strategy = strategy;
  }

  // Method to execute payment
  executePayment(amount: number) {
    this.strategy.pay(amount);
  }
}

// 4. Client code
const amountToPay = 123;

const paymentContext = new PaymentContext(new CreditCardPayment());
paymentContext.executePayment(amountToPay); // Paid 123 using credit card

// Change the strategy to PayPal
paymentContext.setStrategy(new PayPalPayment());
paymentContext.executePayment(amountToPay); // Paid 123 using PayPal

// Change the strategy to Cash
paymentContext.setStrategy(new CashPayment());
paymentContext.executePayment(amountToPay); // Paid 123 using cash