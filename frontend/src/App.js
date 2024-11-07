import { useState, useEffect } from "react";

import "./App.css";

function App() {
  const [productId, setProductId] = useState(0);
  const [qunatity, setQunatity] = useState(0);
  const handleProductChange = (event) => {
    setProductId(event.target.value);
  };

  const handleQuantityChange = (event) => {
    setQunatity(event.target.value);
  };

  useEffect(() => {
    const script = document.createElement("script");
    script.src = "https://checkout.razorpay.com/v1/checkout.js";
    script.async = true;
    document.body.appendChild(script);
  }, []);

  const onSubmit = (e) => {
    e.preventDefault();
    makePostCall(productId, qunatity)
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        console.log(data);
        pay(data.order.modelJson.map);
        // console.log(data.order.modelJson.map);
      })
      .catch((err) => {});
  };

  return (
    <div className="App">
      <h1>Hello world</h1>
      <form onSubmit={onSubmit}>
        <label>productId:</label>
        <input value={productId} onChange={handleProductChange} type="number" />
        <br />
        <label>qunatity:</label>
        <input value={qunatity} onChange={handleQuantityChange} type="number" />
        <br />
        <button id="rzp-button1" type="submit">
          Pay
        </button>
      </form>
    </div>
  );
}

function pay(data) {
  console.log("in payment");
  let options = {
    key: "1111",
    // Enter the Key ID generated from the Dashboard
    amount: "50000",
    // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    currency: "INR",
    name: "Acme Corp",
    description: "Test Transaction",
    // image: "https://example.com/your_logo",
    order_id: data.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    handler: function (response) {
      alert(response.razorpay_payment_id);
      alert(response.razorpay_order_id);
      alert(response.razorpay_signature);
    },
    prefill: {
      name: "Gaurav Kumar",
      email: "gaurav.kumar@example.com",
      contact: "9000090000",
    },
    notes: {
      address: "Razorpay Corporate Office",
    },
    theme: {
      color: "#3399cc",
    },
  };
  console.log(options);
  var rzp1 = new window.Razorpay(options);
  rzp1.on("payment.failed", function (response) {
    alert(response.error.code);
    alert(response.error.description);
    alert(response.error.source);
    alert(response.error.step);
    alert(response.error.reason);
    alert(response.error.metadata.order_id);
    alert(response.error.metadata.payment_id);
  });
  document.getElementById("rzp-button1").onclick = function (e) {
    rzp1.open();
    e.preventDefault();
  };
}
async function makePostCall(productId, qunatity) {
  let order = {
    userName: "test",
    deliveryAddressId: "1",
    ordersList: [
      {
        productId: parseFloat(productId),
        quantity: parseFloat(qunatity),
      },
    ],
  };

  console.log(order);
  const request = new Request("http://localhost:8080/order", {
    method: "POST",
    body: JSON.stringify(order),
    headers: {
      "Content-Type": "application/json; charset=utf-8",
    },
  });

  const response1 = await fetch(request);
  return response1;
  // console.log(response1.status);
}

export default App;
