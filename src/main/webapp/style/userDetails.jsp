<style>

#UserNavbar {
   display: flex;
    justify-content: space-between;
    background-color: #fff;
    color: #363062;
    <%-- background-color: #363062; --%>
    <%-- background-color: #331D2C; --%>
    align-items: center;
    <%-- color: #F1EAFF;  --%>
}

#UserNavbar  .topnav a {
                margin-right: 20px;
                text-decoration: none;
                color: #363062;
                font-size: 1.1rem;
              }

    .UserCardDetails {
      margin-top: 6rem;
      margin-bottom: 3rem;


    }
    .personalDetails {
    padding: 2rem 4rem;
     margin-bottom: 3rem;
     box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
    }

    .personalDetails h1 {
      font-family: 'Fjalla One', sans-serif;
      font-family: 'Lato', sans-serif;
       font-size: 1.8rem;
       padding-bottom: .9rem;
       color: #363062;
    }
     .personalDetails p {
           font-size: 1.2rem;
       }

       .personalDetails form {
       display: flex;
       flex-direction: column;
       }

       .personalDetails form {
       width: 100%;
            display: flex;
            flex-direction: column;
       }

        .personalDetails form label {
          color: #1A120B;
                padding-bottom: 6px;
                font-weight: 300;}



        .personalDetails form input {
                  box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 5px 0px, rgba(0, 0, 0, 0.1) 0px 0px 1px 0px;
                         color: #1F1717;
                         padding: 0.5rem 1rem;
                         margin-bottom: 1.5rem;
                         width: 80%;
                         border: 1px solid #64868E;
                         background-color: white;
                         box-sizing: border-box;
                         display: block;

              }

              .personalDetails input:focus {
                     outline: none;
                     background-color: #ccc;
                     box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
                 }

                 .ButtonSubmit {
                     padding:  0.8rem 1rem;
                     font-weight: 500;
                     margin-top: 0.9rem;
                     margin-bottom: 0.9rem;
                     width: 34%;
                     font-size: 1rem;
                     letter-spacing: 1px;
                     border-radius: 0.5rem;
                     outline: none;
                     border: 1px solid #b3967e;
                     background-color: #2a2f4f;
                     color: aliceblue;
                     transition: all 2s;
                 }

      .TourPrevDetails {
          display: flex;
          flex-direction: column;
          padding: 3rem 2rem;
          justify-content: center;
          align-items: center;
      }
      .Top, Bottom{
          display: flex;
          width: 50%;
          justify-content: space-between;
      }
      .Top h1,
      .Bottom h1{
            font-size: 2rem;
            color: #5F6F52;
      }



.TourMore {
    display: flex;
    padding-inline: 2rem;

    border-radius: 5px;

}
.TourMoreDetails {
flex: 1;
}
   .BookNowDetails {
        padding: 2rem;
        flex: 0 0 22%;
        box-shadow: rgba(0, 0, 0, 0.16) 0px 10px 36px 0px, rgba(0, 0, 0, 0.06) 0px 0px 0px 1px;
        display: flex;
        flex-direction: column;
}

.BookNowDetails p {
text-decoration: underline;
padding-bottom: .5rem;
}
.BookNowDetails span {
text-decoration: none;
    font-weight: 700;
    font-size: 1.2rem;
}

.BookNowDetails button {
        padding: .5rem 1rem;
         border: 1px solid #64868E;
        background-color: #5F6F52;
        width: 100%
}

    .BookNowDetails input {
        padding: .5rem 1rem;
        width: 100%;
         border: 1px solid #64868E;
         color: #1F1717;
         margin-bottom: 1.5rem;
          background-color: white;
           box-sizing: border-box;
                      display: block;
    }



        .BookNowDetails input:focus {
            outline: none;
            background-color: #ccc;
            box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
        }

</style>