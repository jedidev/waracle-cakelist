# waracle-cakelist
Coding Exercise for potential Waracle Android Developer contract

The app meets all the required functionality as specified in the brief. 
The app also meets extra credit requirement 1 as a consequence of using Android's viewModels architecture pattern. Whilst the Activity is reconstructed each time there is an orientation change, the same viewModel is provided.

I have not implement extra credit requirements 2 & 3 at this time, but can do so on request.

My approach in this exercise is to demonstrate how common libraries can be used together, so whilst the use of Dagger may be overkill for a small project, it does demonstrate how Dagger can be used with viewModels etc, which is fairly non standard.

Common libraries which have been used include: Retrofit, Dagger, Picasso, Robolectric.

Less common is my use of the bindingcollectionadapter library.  I elected to use this as, if I had more time I would have coded my own generic recyclerview adapter logic to work with bindings.
