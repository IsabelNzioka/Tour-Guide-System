<style>
  body, * {
    margin: 0;
    padding: 0;
    font-family: 'Lato', sans-serif;
    font-size: 1rem;
  }

  .NavbarContent {
    display: flex;
    justify-content: space-between;
    background-color: #363062;
    <%-- background-color: #331D2C; --%>
    align-items: center;
    color: #F1EAFF;
  }

  .NavbarContent span {
    font-family: 'Fjalla One', sans-serif;
    padding-left: 2.6rem;
    font-size: 2.6rem;
  }

  .topnav {
    display: flex;
    padding: 2.6rem;
    margin-bottom: 10px;
  }

  .topnav a {
    margin-right: 20px;
    text-decoration: none;
    color: #F1EAFF;
    font-size: 1.1rem;
  }

  .topnav a:hover {
    color: #7F669D;
  }

  .topnav a.active {
    text-decoration: underline #7F669D;
  }

  .Divs {
    background-color: #f2f2f2;
    padding: 20px;
    margin-bottom: 20px;
  }

  .HomePage {
    background-image: url('https://images.unsplash.com/photo-1553697388-94e804e2f0f6?auto=format&fit=crop&q=80&w=1530&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D');
    background-position: 50% 30%;
    background-repeat: no-repeat;
    background-size: cover;
    height: 100vh;
  }

  .ToursList {
    margin: 5rem 3rem;
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    grid-gap: 2rem;
    transition: transform 0.5s;
  }

  .card {
    <%-- padding-bottom: 1rem; --%>
    padding-top: 0.8rem;
    border: 1px solid #ccc;
    text-align: center;
    box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
    border-radius: 5px;
      transition: transform 0.3s;
  }
  .card:hover {
     transform: scaleY(1.02);
    box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
  }

  .card img {
    width: 100%;
    height: 400px;
    border-radius: 5px;
  }

  .card h3 {
    font-size: 1.1rem;
    padding: 5px;
  }

  .card p {
    font-size: 1rem;
    padding: 5px;
  }

  .Price {
    font-size: 1.2rem;
    color: #B2533E;
  }

  .UserPage {
    margin-top: 6rem;
    color: #B2533E;
  }

  .WelcomeUser {
    padding-left: 2.6rem;
    padding-top: 1.4rem;
    font-size: 1.4rem;
    color: #B2533E;
  }


</style>